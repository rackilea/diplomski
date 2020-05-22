for(int i = 0 ; i < labelsP1.length ; i++)
{
    labelsP1[i] = new JLabel(B1); 
    for(int j = 0 ; j < labelsP2.length ; j++)
    {
        labelsP2[j] = new JLabel(B2); 
    }
    for (JLabel label : labelsP1)   // null only labelsP1[0] is initialized
    {
        pieces.add(label);        
    }

    Container c = b.getContentPane();
    c.setLayout(new GridLayout(13,3)); 
    c.add(pieces);
}