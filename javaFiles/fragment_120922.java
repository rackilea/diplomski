<s:iterator value="regions">
    <li>
        <div class="listClass">

            <input type = "checkbox" 
                     id = "myTheater" 
<s:if test="%{value in selectedRegions.{value}}">
                checked = "checked"
</s:if>
                   name = "theaterCheckBox" 
                  class = "theaterCheckBox" />

            <s:property value="value" />
        </div>
        <div class="checkboxDiv">
            <input type="checkbox" id="allFeatured" class="featuredCheckBox" />
        </div>
    </li>
</s:iterator>