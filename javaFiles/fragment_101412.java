private void updateAppPanel(String panelName) {
    // TODO Auto-generated method stub
    if(panelName.equalsIgnoreCase("General")){
        tabContainer.removeAll();
        tabContainer.add(new GeneralPage());
    } 
    else if (panelName.equalsIgnoreCase("Task Bar")){
        tabContainer.removeAll();
        tabContainer.add(new TaskBarPage());
    }
    else if (panelName.equalsIgnoreCase("Language")){
        tabContainer.removeAll();
        tabContainer.add(new LanguagePage());
    }
    else if (panelName.equalsIgnoreCase("Look and Feel")){
        tabContainer.removeAll();
        tabContainer.add(new LookFeelPage());
    } 
    else if (panelName.equalsIgnoreCase("Country")){
        tabContainer.removeAll();
        tabContainer.add(new CountryPage());
    }
    appScrollPanel.revalidate();
    appScrollPanel.repaint();   
}