<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

                            <table id="payout" class="display" style="float:left; width: 100%;border-radius: 
                 5px 5px 5px 5px;
                        box-shadow: 2px 2px 6px #666666;-moz-box-sizing: none;" border=1  data="${payout}">

                            <thead style="color: red">

                      <tr>
                            <td class="heading">Charge</td>
                            <td class="heading">Cost Before Discount</td>
                            <td class="heading">After Plan Discount</td>
                            <td class="heading">After Booking Discount</td>


                     </tr> 
                </thead>
                <tbody>
        <c:forEach items="${payouts}" var="payout" varStatus="row">
                        <tr>
                             <td >Base Cost</td> 
                             <c:set var="basecost" value="payout.baseCost.costBeforeDiscount" />
                            <td><fmt:formatNumber pattern="########.####"   
          value="${payout.baseCost.costBeforeDiscount}"/></td>
                             <c:set var="basecost" value="payout.baseCost.afterPlanDiscount" />
                             <td><fmt:formatNumber pattern="########.####" 
           value="${payout.baseCost.afterPlanDiscount}"/></td>
                            <c:set var="basecost" value="payout.baseCost.afterBookingDiscount" />
                             <td><fmt:formatNumber pattern="########.####" 
           value="${payout.baseCost.afterBookingDiscount}"/></td>

                        </tr>

                    </c:forEach>
                </tbody>
                </table>