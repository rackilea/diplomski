class FortuneAppenderAction implements ActionListener {

    private String lastFortune = null;

    @Override
    public void actionPerformed( ActionEvent e ) {
        Random rand = new Random();
        String x;
        do {
            x = fortunes[rand.nextInt( fortunes.length )];
        }
        while ( x.equals( lastFortune ) );
        lastFortune = x;
        txaResults.append( x + "\n" );
    }
}