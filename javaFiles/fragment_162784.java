<form:select path="colorCode" class="monthanddates" cssStyle="background: ${colorCode}"  onChange="this.style.backgroundColor=this.options[this.selectedIndex].style.backgroundColor">
                <form:option value="" style="background:#FFFFFF" label="select" />
                <c:forEach items="${color}" var="colorMap">
                    <option value="${colorMap.value}" style="background: ${colorMap.value};"></option>
                </c:forEach>
            </form:select>