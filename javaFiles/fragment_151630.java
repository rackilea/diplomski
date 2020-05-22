public boolean BookDateControl(){
        if(!StringUtils.hasLength(BookDatetextfield.getText()) || !StringUtils.hasText(BookDatetextfield.getText())){
            errorLable.setText("Empty Book Date");
            return false;
        }
        bookinform.setBookDate(BookDatetextfield.getText().trim());

        if(bookinform.getBookDate().trim().isEmpty()){
            errorLable.setText("Empty Book Date");
            return false;
        } else if(haveSpace(bookinform.getBookDate().trim())){
            errorLable.setText("Space in Book Date!");
            return false;
        } else if(haveletter(bookinform.getBookDate().trim())){
            errorLable.setText("Letter in Book Date");
            return false;
        }

        return true;
    }