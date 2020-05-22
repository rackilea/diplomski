@Autowired
private AccountTransactionPane transactionPane;

...

public AccountTab() {
    this.setLayout(new BorderLayout());
    JScrollPane scrollPane = new JScrollPane(this.table);
    splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, transactionPane);
    splitPane.setEnabled(false);
    this.add(splitPane, BorderLayout.CENTER);
}