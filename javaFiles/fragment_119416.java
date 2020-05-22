<select size="10" id="listaSeguimientos">
                <optgroup label="Reclamos por atender.">
                <c:forEach var="conteo0" items="${conteo0}" varStatus="theCount">
                    <option ondblclick='myFunction()'>${conteo0}</option>
                </c:forEach>
                </optgroup>
            </select>