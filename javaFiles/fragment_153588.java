package com.oracle.client;

import java.math.BigDecimal;

import com.oracle.sca.soapservice.poprocessing.poprocessing.receivepo.ExecutePtt;
import com.oracle.sca.soapservice.poprocessing.poprocessing.receivepo.ReceivePO;
import com.oracle.xmlns.ns.order.ObjectFactory;
import com.oracle.xmlns.ns.order.PurchaseOrderType;

public class SOAClient {
    public static void main(String[] args) {

        ReceivePO recPOService = new ReceivePO();
        ExecutePtt recPOPort = recPOService.getExecutePt();
        PurchaseOrderType purchaseOrder = new ObjectFactory()
                .createPurchaseOrderType();

        purchaseOrder.setCustID("1111");
        purchaseOrder.setID("2121");
        purchaseOrder.setProductName("Bluetooth Headset");
        purchaseOrder.setItemType("Electronics");
        BigDecimal bd_p = new BigDecimal("49.99");
        purchaseOrder.setPrice(bd_p);
        BigDecimal bd_q = new BigDecimal("10");
        purchaseOrder.setQuantity(bd_q);
        purchaseOrder.setStatus("initial");
        purchaseOrder.setCcType("Mastercard");
        purchaseOrder.setCcNumber("8765-8765-8765-8765");

        recPOPort.execute(purchaseOrder);

    }
}