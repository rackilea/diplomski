Object q1 = entityManager.createNativeQuery("call rrear_etl_processing.Sp_UpdateOATSROE( ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26, ?27, ?28, ?29, ?30, ?31, ?32, ?33, ?34, ?35, ?36, ?37, ?38, ?39, ?40, ?41, ?42, ?43, ?44, ?45, ?46, ?47, ?48, ?49, ?50, ?51, ?52, ?53, ?54, ?55, ?56, ?57, ?58, ?59, ?60, ?61, ?62, ?63, ?64, ?65, ?66, ?67, ?68, ?69, ?70, ?71, ?72, ?73, ?74, ?75, ?76, ?77, ?78, ?79, ?80, ?81, ?82, ?83, ?84, ?85, ?86, ?87, ?88, ?89, ?90, ?91, ?92, ?93, ?94, ?95, ?96, ?97, ?98, ?99, ?100, ?101, ?102, ?103, ?104, ?105, ?106, ?107, ?108, ?109, ?110, ?111, ?112, ?113 ,?114, ?115, ?116, ?117)")
                        .setParameter(1,P_RowID)
                        .setParameter(2,P_Exception_CD)
                        .setParameter(3,P_Exception_Description)
                        .setParameter(4,P_ORDER_EVENT_TYPE)
                        .setParameter(5,P_OrderDatetime)
                          *
                          *
                    .setParameter(115,P_MPID_OATS_Exc_ID )
                    .setParameter(116,P_Report_Header_ID)
                    .setParameter(117,P_Updated_By)
                    .executeUpdate();