<%
Map<int, ArrayList<String>> engines = new Map<int, ArrayList<String>>();
ArrayList<Integer> carList = CarListDAO.getCar(id);
for (int c: carList){
    ArrayList<String> carEngine = CarListDAO.getCarEngine(c);
    engines.put(c, carEngine);
}
%>
<script>
var engines = <%out.println(JSONObject.valueToString(engines));%>;
function showEngines() {
    var el= document.getElementById('carid');
    for(var i=0;i<el.options.length;i++) {
        if (el.options[i].selected) {
            bindEngines(el.options[i].value);
            break;
        }    
    }
}
function bindEngines(c) {
    var el=document.getElementById('carENGINE');
    el.options.length = 0;
    var newOptions= engines[c];
    for (i=0; i<newOptions.length; i++) 
    {
        el.options[el.length] = new Option(newOptions[i], newOptions[i]);
    }
}
</script>

<div class="cell">
    Select Car_Type
    <div class="input-control">
        <select id="carid" name="carid" change="showEngines()">
        <option selected disabled>--SELECT CAR TYPE--</option>
        <%
        for (int c: carList){
            out.println("<option value='" + c + "'>" + c + "</option>");
        }

        %>
        </select>

    </div>
</div>


<div class="cell">
    Select Car_Engine
    <div class="input-control">
        <select id="carENGINE" name="carENGINE" disabled>
        <option selected disabled>--SELECT CAR Engine--</option>
        </select>

    </div>
</div>