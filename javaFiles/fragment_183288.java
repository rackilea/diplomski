Object[] cids=final_cats.toArray();
String cds="";
for(Object o:cids) {

        cds=cds+o+",";
}

cds=cds.substring(0, cds.length()-1);

String query="select fpd from FTextProductDetails ftpd inner join ftpd.fProductDetails fpd WHERE fpd.categoryId in( "+cds+")and ftpd.productName like ?" ;
Object[] values=new Object[]{'%'+productName+'%'};
List<Object[]> list = HibernatePaginationImpl.findProductsByName(query, values,pageSizeLimit , pageNumber,this.baseDao);