WebElement e;
while(it.hasNext())
    e = it.next();
    if(e.getText().equals(cat)) {
        e.click();
    }
}