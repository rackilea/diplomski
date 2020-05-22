String shipping = "Regular"
double shippingCost=0;
switch (shipping) {
    case "Regular":
            shippingCost += 0;
            break;
    case "Express":    
            shippingCost += 1.75;
            break;
    default:
            shippingCost += .50; 
}
return shippingCost;