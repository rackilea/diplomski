<%import org.codehaus.groovy.grails.commons.GrailsClassUtils;%>
<%=packageName ? "package ${packageName}\n\n" : ''%>
class ${className}Service {

    def getTable() {
        def query = {
            <%
                def searchFields = GrailsClassUtils.getStaticPropertyValue(domainClass.clazz, 'search' )
                if(searchFields)
                {
            %>
                    if (params.q) {
                        or{
                        <%searchFields.each { field ->%>
                            ilike("${field}", '%' + params.q + '%')
                        <%}%>
                        }
                    }
            <%  }   %>
            if (params.sort){
                order(params.sort,params.order)
            }
        }
        def criteria = ${className}.createCriteria()
        return criteria.list(query, max: params.max, offset: params.offset)
    }
}