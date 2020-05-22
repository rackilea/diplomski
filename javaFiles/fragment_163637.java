StringBuilder str="";

for (int i = 0; i < knowledgeD.size(); i++ )
{
        w =knowledgeD.get(i).get(0);
            y = knowledgeD.get(i).get(1);

    str.append("{true@" + w + " " +"false@"  + w.complement() + "}" + "@" + this.y);
     str.append(" ");
}