function Total(v) 
      {   
//var closingbalnce=parseFloat(v);
var  closingbalnce=parseFloat(v);   
var hidden=parseFloat(document.name.hidden.value);    
var op="openingbalance".concat(hidden);  
var ts="ticketssold".concat(hidden); 
var v="value".concat(hidden);  
var openingbalance=parseFloat(document.getElementById(op).value);
var ticketssold=parseFloat(document.getElementById(ts).value); 
var value=parseFloat(document.getElementById(v).value); 
var totalsoldtickets=closingbalnce-openingbalance; 
var totalsoldtickets=(closingbalnce-openingbalance)*value;  
document.getElementById(ts).value=totalsoldtickets;
//document.name.ticketssold.value=total; 
alert("hiiii "+total);
 }

     <c:forEach items="${scratchlistlotto }" var="sl">
      <tr class="fontstyle">
        <td  class="table_color1"><input  name="scratchid" type="hidden"  class="table_color1" id="scratchid" style="text-align:center" size="2" value="${sl.scratchid }" />
        <input name="binid" type="text" readonly="readonly" class="table_color1" id="binid" style="text-align:center" size="2" value="${sl.bin }" /></td>
        <td class="table_color1"><input readonly="readonly" name="upccode" type="text" class="table_color1" id="upccode" style="text-align:center" size="25" readonly="readonly" value="${sl.upccode }" /></td>
        <td class="table_color2"  ><input readonly="readonly" name="totalticketss" type="text" class="table_color22" id="totalticketss${sl.i }" style="text-align:right" size="6" value="${sl.totaltickets }"/></td>
        <td class="table_color2"  ><input readonly="readonly" name="openingbalance${sl.i }" type="text" class="table_color22" id="openingbalance${sl.i }"   size="6" value="${sl.closingbalance }" /></td>
        <td><input name="closingbalnce" type="text" class="text_border" onclick="Click(${sl.i })" id="closingbalnce" onchange="javascript:Total(this.value)"   style="text-align:right" size="6" /></td>
        <td class="table_color2"><input readonly="readonly" name="value" type="text" class="table_color22" id="value${sl.i }" style="text-align:right" size="6" value="${sl.values }" /></td>
        <td class="table_color2"  ><input readonly="readonly" name="ticketssold" type="text" class="table_color22" id="ticketssold${sl.i }" style="text-align:right" size="6" /></td>
        <td class="table_color2"  ><input readonly="readonly" name="total" type="text" class="table_color22" id="total${sl.i }" style="text-align:right" size="6" /> 
        </td>
        <td width="38" align="center"><input name="endoflife" type="checkbox" class="text_border" id="endoflife"    /></td>
        </tr></c:forEach>
         <input type="hidden" name="hidden"  value="0"/>