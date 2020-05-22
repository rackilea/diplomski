<c:forEach
                            items="#{userRequestBean.showMessages(userRequestBean.request, agency[1])}"
                            var="message">

                            <h:outputText value="#{message[1]}"
                                style="width: 100px; white-space: normal; border: 3px" />
                    </c:forEach>