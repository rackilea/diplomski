@ContextConfiguration(classes = {ScanResultConfigureController.class})
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,
                        value = {ScanResultConfigureController.class})
        },
        useDefaultFilters = false,
        lazyInit = true
)