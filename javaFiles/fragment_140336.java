package forum13075432;

import java.util.List;
import org.eclipse.persistence.oxm.annotations.*;

public class Root {

    @XmlTransformation
    @XmlReadTransformer(transformerClass = GeneralAttributeMarkerTransformer.class)
    @XmlWriteTransformers({
            @XmlWriteTransformer(xmlPath = "ORDER_HEADER/SHIPPING_INFO/SHIPMENT_CODE/text()", transformerClass = ShippingInfoTransformer.class),
            @XmlWriteTransformer(xmlPath = "ORDER_HEADER/SHIPPING_INFO/SHIPPING_COST_EX_VAT/text()", transformerClass = ShippingInfoTransformer.class),
            @XmlWriteTransformer(xmlPath = "ORDER_HEADER/SHIPPING_INFO/SHIPPING_COST_VAT/text()", transformerClass = ShippingInfoTransformer.class),
            @XmlWriteTransformer(xmlPath = "ORDER_HEADER/SHIPPING_INFO/SHIPPING_COST_INC_VAT/text()", transformerClass = ShippingInfoTransformer.class), })
    public SupplierOrderCharge getShippingInfo() {
        for (final SupplierOrderCharge soCharge : getOrderCharges()) {
            if (EntryType.SHIPPING.equals(soCharge.getEntryType())) {
                return soCharge;
            }
        }
        return null;
    }

    public void setShippingInfo(SupplierOrderCharge s) {
    }

    private List<SupplierOrderCharge> getOrderCharges() {
        // TODO Auto-generated method stub
        return null;
    }

}