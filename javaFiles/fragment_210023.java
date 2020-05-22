@Autowired
private JdbcTemplate jdbcTemplate

@Override
public void bulkInsert(Collection<SortingPlanData> data, SortingPlan plan) {
    String sql = "insert into SORTING_PLAN_DATA (ACHEMINEMENT, ANCIEN_GROUPE_SERVICE_LABELS, BAG_ID, BARCODE_ID, CHRONOSERVICE, CODE_ROUTING, D_DEPOT_NUMBER, D_SORT, DELIVERY_STATION, DESCRIPTION, DESTINATION_PAYS_ALPHA2_ISO, DESTINATION_PAYS_ALPHA3_ISO, DESTINATION_PAYS_NUM_ISO,"
            + " DIST, GROUPE_SERVICE_LABELS, GROUPING_PRIORITY, LIVRAISON, O_SORT, ORIGINE_PAYS_ALPHA2_ISO, ROUTING_PLACES, S_SORT, SENDING_DATE, SERVICE_CODES, SITE_IATA, SORTING_PLAN_ID, TYPE_EXPORT, VILLE, ZIP_MAX, ZIP_MIN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    jdbcTemplate.batchUpdate(sql, data, 500, new ParameterizedPreparedStatementSetter<SortingPlanData>() {
        public void setValues(PreparedStatement ps, SortingPlanData spd) throws SQLException {
            ps.setString(1, spd.getAcheminement());
            ps.setString(2, spd.getAncienGroupeServiceLabels());
            ps.setString(3, spd.getBagId());
            ps.setString(4, spd.getBarcodeId());
            ps.setString(5, spd.getChronoservice());
            ps.setString(6, spd.getCodeRouting());
            ps.setString(7, spd.getDDepotNumber());
            ps.setString(8, spd.getDSort());
            ps.setString(9, spd.getDeliveryStation());
            ps.setString(10, spd.getDescription());
            ps.setString(11, spd.getDestinationPaysAlpha2Iso());
            ps.setString(12, spd.getDestinationPaysAlpha3Iso());
            ps.setInt(13, spd.getDestinationPaysNumIso());
            ps.setString(14, spd.getDist());
            ps.setString(15, spd.getGroupeServiceLabels());
            ps.setString(16, spd.getGroupingPriority());
            ps.setString(17, spd.getLivraison());
            ps.setString(18, spd.getOSort());
            ps.setString(19, spd.getOriginePaysAlpha2Iso());
            ps.setString(20, spd.getRoutingPlaces());
            ps.setString(21, spd.getSSort());
            ps.setDate(22, new java.sql.Date(System.currentTimeMillis()));
            ps.setString(23, spd.getServiceCodes());
            ps.setString(24, spd.getSiteIata());
            ps.setLong(25, plan.getId());
            ps.setString(26, spd.getTypeExport());
            ps.setString(27, spd.getVille());
            ps.setString(28, spd.getZipMin());
            ps.setString(29, spd.getZipMax());
        }
    });
}