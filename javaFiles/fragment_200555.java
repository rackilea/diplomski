String company = ""
            + "V.K Autos Larkana\n"
            + "Near Rehmaniya Masjid Larkana\n"
            + "Police Shopping Center Larkana\n"
            + "Cell: 0334-3269198, 0333-3910951\n"
            + " \n"
            + "CUSTOMER INVOICE"
            + " ";

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    List<String> t1Headers = Arrays.asList("INFO", "CUSTOMER");
    List<List<String>> t1Rows = Arrays.asList(
            Arrays.asList("DATE: " + date + "", "" + txt_cnam.getText()),
            Arrays.asList("TIME: " + sdf.format(cal.getTime()) + "", "Bill No:" + billno + "")
    );
    String t2Desc = "SELLING DETAILS";
    List<String> t2Headers = Arrays.asList("ITEM", "QTY", "Rate", "Total");

    List<List<String>> t2Rows = new ArrayList<List<String>>();

    for (int i = 0; i < tbl_sale.getRowCount(); i++) {
        String pid = tbl_sale.getValueAt(i, 0).toString();
        String item = tbl_sale.getValueAt(i, 1).toString();
        String quant = tbl_sale.getValueAt(i, 2).toString();
        String rate = tbl_sale.getValueAt(i, 3).toString();
        String rs = tbl_sale.getValueAt(i, 4).toString();
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(item);
        temp.add(quant);
        temp.add(rate);
        temp.add(rs);
        t2Rows.add(temp);
    }
    List<Integer> t2ColWidths = Arrays.asList(16, 5, 7, 9);
    String t3Desc = "Sub Total";
    List<String> t3Headers = Arrays.asList("", "", "", "");
    List<List<String>> t3Rows = Arrays.asList(
            Arrays.asList("WR-DVD", "122.00", "7", "854.00")
    );

    String summary = ""
            + "Sub Total\n";

    String summaryVal = ""
            + txt_total.getText() + "\n";
    String sign1 = ""
            +"------Thank you for your visit------\n";
    String sign2 = ""
            + "-We value your visit-\n";
    String advertise = "******** Soulution by AbroSoft *******\n* abrosoft@outlook.com # 03337584273 *";
    try {
        Board b = new Board(48);
        b.setInitialBlock(new Block(b, 40, 6, company).allowGrid(true).setBlockAlign(Block.BLOCK_LEFT).setDataAlign(Block.DATA_CENTER));
        b.appendTableTo(0, Board.APPEND_BELOW, new Table(b, 42, t1Headers, t1Rows));
        b.getBlock(3).setBelowBlock(new Block(b, 40, 1, t2Desc).setDataAlign(Block.DATA_CENTER));
        b.appendTableTo(5, Board.APPEND_BELOW, new Table(b, 40, t2Headers, t2Rows, t2ColWidths));
        Block summaryBlock = new Block(b, 30, 1, summary).setDataAlign(Block.DATA_TOP_RIGHT);
        b.getBlock(10).setBelowBlock(summaryBlock);
        Block summaryValBlock = new Block(b, 9, 1, summaryVal).setDataAlign(Block.DATA_TOP_RIGHT);
        summaryBlock.setRightBlock(summaryValBlock);
        Block sign1Block = new Block(b, 40, 1, sign1).setDataAlign(Block.DATA_CENTER);
        b.getBlock(14).setBelowBlock(sign1Block);
        Block sign2Block = new Block(b, 40, 2, advertise).setDataAlign(Block.DATA_CENTER);
        b.getBlock(16).setBelowBlock(sign2Block);
        System.out.println(b.invalidate().build().getPreview());