@Override
public void actionPerformed(ActionEvent e) 
{
    Object input = e.getSource();


    if(input == UKLang)
    {
        currentLocale = new Locale("en");
        labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
    }

    else if(input == DELang)
    {
        currentLocale = new Locale("de");
        labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
    }

    else if(input == FRLang)
    {
        currentLocale = new Locale("fr");
        labels = ResourceBundle.getBundle("LabelsBundle_fr", currentLocale);
    }

    else if(input == POLLang)
    {
        currentLocale = new Locale("pl");
        labels = ResourceBundle.getBundle("LabelsBundle_pol", currentLocale);
    }
     //Here you go. the magical code to do that
     resultWaveLabel.setText(labels.getString("blabla"));///Here that's it your label is updated with the text 
}