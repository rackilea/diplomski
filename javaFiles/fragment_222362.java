public function newAction() {
    $cart = $this->_getCart();
    try {
        //getting list of products
        $filter = new Zend_Filter_LocalizedToNormalized(array('locale' => Mage::app()->getLocale()->getLocaleCode()));
        for ($i = 1; $i <= 4; $i++) {
            echo '<br>';
            $param = $_GET['product' . $i];
            if (isset($param)) {
                $param = explode("/", $param);
                print_r($param);
                $productId = $param[0];
                $product = $this->addNewProduct($productId);
                $quantity = $filter->filter($param[1]);
                $params['product'] = $product;
                $params['qty'] = $quantity;

                $cart->addProduct($product);
            }// if over
        }//for over
        $cart->save();
        $message = $this->__('Added to Your Cart Successfully', Mage::helper('core')->escapeHtml());
        $this->_getSession()->addSuccess($message);
        Mage::getSingleton('checkout/session')->setCartWasUpdated(true);
        $this->_redirect("checkout/cart/");
    } catch (Mage_Core_Exception $e) {}