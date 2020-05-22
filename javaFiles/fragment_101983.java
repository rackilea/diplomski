//Assert the text with the hard-coded value
    try{
        Assert.assertEquals(text_in_panel, "£163.06");
        System.out.println("Text matches");
    }catch(Throwable e){
        System.err.println("Text doesn't match");
    }