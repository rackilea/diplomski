<div class="container">
<div class="box theme well">
<div id="itemListing">
    <c:forEach items="#{product.allItems}" var="productItem" >

                <!--/ Removed the ".container" wrapping -->

                <div class="dash-unit col-sm-2">                            
                    <div style="color: lightskyblue; margin: 4px; ">#{productItem.title}</div>
                    <hr style="color: white;" />
                    <img src="#{product.IMG_URL}#{productItem.img_url}" />
                    <br/>
                    <br/>
                    Genre: #{productItem.genre}
                    <br/>
                    Tillverkare: #{productItem.manufacturer}
                    <br/>
                    Pris: #{productItem.price}
                    <br/>
                    <br/>
                    <div style="color: greenyellow;">Lagersaldo: #{productItem.quantity}</div>
                </div>


    </c:forEach>
</div> 
</div>
</div>