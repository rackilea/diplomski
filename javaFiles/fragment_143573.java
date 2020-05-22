<c:forEach items="${brandlist}" var="brand" begin="0" end="5"
varStatus="loop">
<div class="custom-control custom-checkbox">
    <input type="checkbox" class="custom-control-input"
        id="${brand.brand}" name="${brand.brand}"> <label
        class="custom-control-label" for="${brand.brand}">${brand.brand}</label>
</div>