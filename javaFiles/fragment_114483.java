public void degreeFilter(ValueChangeEvent dege) {  
    Object[] objArr = (Object[])dege.getNewValue();
    for (int x = 0; x < objArr.length; x++)
    {
        Object obj = objArr[x]; 
        System.out.println(obj.toString());
        degree=obj.toString();
    }
}