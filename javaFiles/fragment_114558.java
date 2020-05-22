JPanel panel = new JPanel( ); // specify your layout manager here

for(int i=0;i<3;i++)
{
    panel.add( new ItemCurso() );
}

jScrollPane1.getViewport().add(panel);