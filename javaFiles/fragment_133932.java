function JSGetSelectedItem() {
   var dropdownIndex = document.getElementById('service').selectedIndex;
   var dropdownValue = document.getElementById('service')[dropdownIndex].text;
} 

<select id="service" onChange="JSGetSelectedItem()">
            <option value="GSM">GSM</option>
            <option value="CDMA">CDMA</option>
</select>