$productData = new stdClass();
    $additionalAttrs = array();

            // manufacturer from one of the two above ^

    $productData->name                   = $data['name']; 
    $productData->description            = $data['description'];
    $productData->short_description      = $data['short_description'];
    $productData->weight                 = 0;
    $productData->status                 = 2; // 1 = active
    $productData->visibility             = 4; //visible in search/catalog
    $productData->category_ids           = $data['categories']; 
    $productData->price                  = $data['price'];
    $productData->tax_class_id           = 2; // 2=standard
    $productData->additional_attributes  = $additionalAttrs;

    // Create new product
    try {
        $proxy->catalogProductCreate($sessionId, 'virtual', 9, $sku, $productData); // 9 is courses
    } catch (SoapFault $e) {
        print $e->getMessage();  //Internal Error. Please see log for details.
        exit();
    }