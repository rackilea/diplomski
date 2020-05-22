XSSFWorkbook wb = new XSSFWorkbook();
XSSFPivotTable firstPivot = preparefirstPivot(...);
XSSFPivotTable secondPivot = preparesecondPivot(...);
XSSFPivotTable thirdPivot = preparethirdPivot(...);

/* START: shared cache */
                List<CTPivotCache> ctPivotCacheList = wb.getCTWorkbook().getPivotCaches().getPivotCacheList();
                if (ctPivotCacheList != null && ctPivotCacheList.size() > 1) {
                    /* useful only with more than one PivotCache */
                    List<Long> ctPivotCacheIdList = new ArrayList<Long>();
                    for (int i = 0; i < ctPivotCacheList.size(); i++) {
                        CTPivotCache ctPivotCache = ctPivotCacheList.get(i);
                        ctPivotCacheIdList.add(new Long(ctPivotCache.getCacheId()));
                    }

                    long firstPivotCacheId = firstPivot.getCTPivotTableDefinition().getCacheId();
                    for (int i = ctPivotCacheIdList.size() - 1; i >= 0; i--) {
                        if (ctPivotCacheIdList.get(i) != firstPivotCacheId) {
                            ctPivotCacheList.remove(i);
                        }
                    }

                    secondPivot.getCTPivotTableDefinition().setCacheId(firstPivotCacheId);
                    secondPivot.setPivotCache(firstPivot.getPivotCache());
                    thirdPivot.getCTPivotTableDefinition().setCacheId(firstPivotCacheId);
                    thirdPivot.setPivotCache(firstPivot.getPivotCache());
}