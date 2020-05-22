<style type="text/css"> 
    @page { size:letter; padding:0; margin:0.5in 25px 100px 25px;}
    *{ font-family: "verdana", tahoma, arial, sans-serif;}
     table { -fs-table-paginate: paginate; thead {
    display:table-header-group;}}
    @page {
         @top-center { content: element(header) }
    }
    @page:first {
        margin:30px 25px 100px 25px;
         @top-center { content: element() }
    }
    table.header {
        height:100px;
        display: block; text-align: center; 
        position: running(header);
    }
    div.footer {
        display: block; text-align: center;
        position: running(footer);
    }
    div.content {page-break-after: always;}

     #footer {
    position: running(footer);
    text-align: right;
    }

    #pagenumber:before {
    content: counter(page);  }

    #pagecount:before {
    content: counter(pages);  }


</style>