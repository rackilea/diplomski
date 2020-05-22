for(int i=0;i<li.size();i++){
    ...
        Pair p = new Pair(
                li.get(i).getText().trim().substring(10, 16),
                defectidList.get(i),
                hreflink.get(i).getText()
                );
    ...
}