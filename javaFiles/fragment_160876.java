@Log4j2
@Service
public class PrintService implements Printable {

@Autowired
private PreviewManager previewManager;

public boolean printCopies() {

    final JPanel printPanel = new JPanel();
    DefaultListModel listModel = new DefaultListModel();

    printPanel.setLayout(new BoxLayout(printPanel, BoxLayout.PAGE_AXIS));
    printPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    JLabel label = new JLabel("Select the number of copies");
    listModel.addElement("0");
    listModel.addElement("1");
    listModel.addElement("2");
    listModel.addElement("3");
    listModel.addElement("4");
    listModel.addElement("5");

    final JList list = new JList(listModel);
    list.setVisibleRowCount(1);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setLayoutOrientation(JList.HORIZONTAL_WRAP);

    final int[] nrOfCopies = {1};
    list.addListSelectionListener(lse -> nrOfCopies[0] = Integer.parseInt((String) list.getSelectedValue()));
    printPanel.add(label);

    printPanel.add(list);
    label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    list.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    list.setSelectedIndex(1);
    JOptionPane jop = new JOptionPane(printPanel,
            JOptionPane.PLAIN_MESSAGE,
            JOptionPane.OK_CANCEL_OPTION);
    JDialog dialog = jop.createDialog(EMPTY_STRING);
    dialog.setAlwaysOnTop(true);
    dialog.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentShown(ComponentEvent e) {
            SwingUtilities.invokeLater(list::requestFocusInWindow);
        }
    });
    dialog.setVisible(true);
    int result = (Integer) jop.getValue();
    dialog.dispose();

    if (result == JOptionPane.OK_OPTION) {
        log.info("Printing {} copies of the list", nrOfCopies[0]);
        for (int c = 0; c < nrOfCopies[0]; c++) {
            print();
        }
        return true;
    }
    // todo: bring back
    return false;
}

public void print() {
    PrinterJob pjob = PrinterJob.getPrinterJob();
    javax.print.PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
    for (javax.print.PrintService printer : printServices) {
        // in my case I use a Star TSP143 thermal printer
        if (printer.getName().contains("tsp143")) {
            try {
                pjob.setPrintService(printer);
            } catch (PrinterException e) {
                log.error(e);
            }
        }
    }
    PageFormat preformat = pjob.defaultPage();
    preformat.setOrientation(PageFormat.PORTRAIT);
    PageFormat postformat = pjob.defaultPage(preformat);
    Paper p = preformat.getPaper();
    p.setImageableArea(0, 0, postformat.getWidth(), postformat.getHeight());
    postformat.setPaper(p);

    //If user does not hit cancel then print.
    if (preformat != postformat) {
        //Set print component
        pjob.setPrintable(PrintService.this, postformat);
        try {
            pjob.print();
        } catch (PrinterException ex) {
            log.error(ex);
        }
    }
}


@Override
public int print(Graphics g, PageFormat format, int page_index) {
    // depends on your use case, printableJpanel is going to be the panel you are going to print
    JPanel printableJpanel = previewManager.getPrintablePanel();
    if (page_index > 0) {
        return Printable.NO_SUCH_PAGE;
    }

    // get the bounds of the component
    Dimension dim = printableJpanel.getSize();
    double cHeight = dim.getHeight();
    double cWidth = dim.getWidth();

    // get the bounds of the printable area
    double pHeight = format.getImageableHeight();
    double pWidth = format.getImageableWidth();

    double pXStart = format.getImageableX();
    double pYStart = format.getImageableY();

    double xRatio = pWidth / cWidth;
    double yRatio = pHeight / cHeight;

    Graphics2D g2 = (Graphics2D) g;
    g2.translate(pXStart, pYStart);
    g2.scale(xRatio, 0.80);
    printableJpanel.paint(g2);

    return Printable.PAGE_EXISTS;

    }
}