<tbody>
                            <c:forEach begin="0" end="${ResultNumberCom}" varStatus="loop">
                                <c:forEach items="${Resultat}" var="variable">

                                    <tr>
                                        <td><a href="../CommandeVueController?id=${variable.id[loop.index]}">${variable.id[loop.index]}</a></td>
                                        <td>${variable.echantillonRef[loop.index]}</td>
                                        <td>${variable.conditionnement[loop.index]}</td>
                                        <td><a
                                            href="../TransporteurVueController?id=${variable.transporteurId[loop.index]}">${variable.transporteur[loop.index]}</a></td>
                                        <td>${variable.etat[loop.index]}</td>
                                        <td>${variable.date}[loop.index]</td>
                                        <td>${variable.client}</td>



                                    </tr>
                                </c:forEach>
                            </c:forEach>