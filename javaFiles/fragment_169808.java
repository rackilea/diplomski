PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream("data.xml")));

while(rs.next()){
    i++;
    writer.print("\n\t<row>");
    writer.print("\n\t\t<ID>" + Util.transformToHTML(rs.getInt("id")) + "</ID>");
    writer.print("\n\t\t<JED_ID>" + Util.transformToHTML(rs.getInt("jed_id")) + "</JED_ID>");
    writer.print("\n\t\t<IME_PJ>" + Util.transformToHTML(rs.getString("ime_pj")) + "</IME_PJ>");
    //...

    writer.print("\n\t</row>");
}

writer.close();