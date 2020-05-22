<datatables:table id="mydata" data="${mydataset}" cdn="true" row="mr" theme="bootstrap2" 
    cssClass="table table-striped" paginate="true"  info="false" 
    cssStyle="width: 150px;" align="left" dom="frtp" lengthChange="true">
    <datatables:column title="Concept Type" cssStyle="width: 150px;" display="html">
        <c:out value="${mr.something}"/>
    </datatables:column>
   <datatables:prop name="feature.displayLength" value="15" />
</datatables:table>