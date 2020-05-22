try { 
    font = Font.createFont(Font.TRUETYPE_FONT, 
            trial.class.getClassLoader().getResourceAsStream("Fonts/Origin-Light.ttf")); 
} catch (Exception e) { 
    e.printStackTrace();
}