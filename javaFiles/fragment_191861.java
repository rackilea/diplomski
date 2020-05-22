@Query("SELECT NEW com.htd.domain.ShopOrder(po.id, po.po_number, "
             + "po.due_date, po_part.id, po_part.part_quantity, "
            + "part.id, part.part_number, part.part_description, "
            + "part.plasma_hrs_per_part, part.grind_hrs_per_part, "
            + "part.mill_hrs_per_part, part.brakepress_hrs_per_part) "
            + "FROM Po po "
            + "LEFT JOIN po.partList po_part "
            + "LEFT JOIN po_part.part part "
            + "LEFT JOIN po_part.part where po.id = ?1")
    List<ShopOrder> getShopOrder(Long id);