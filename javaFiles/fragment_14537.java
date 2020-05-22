@(products: List[Productslist])

@import helper._

@main("Product list") {

    <h1>@product.size() product(s)</h1>

    <ul>
        @for(product <- products) {
            <li>
                @product.name
            </li>
        }
    </ul>
}