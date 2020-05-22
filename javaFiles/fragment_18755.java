public void LoadCategory()
{
    //...
    jComboBox1.removeAllItems();
    while(rs.next())
    {
        // rs.getInt('id') - id value of the category record
        jComboBox1.addItem( CategoryItem( rs.getInt('id'), rs.getString('name') );
    }
     //...
}