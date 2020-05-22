.MPartStack {
    swt-tab-renderer: url('bundleclass://org.eclipse.e4.ui.workbench.renderers.swt/org.eclipse.e4.ui.workbench.renderers.swt.CTabRendering');
    swt-selected-tab-fill: INACTIVE_TAB_BG_START INACTIVE_TAB_BG_END 100% 100%;
    swt-unselected-tabs-color: INACTIVE_UNSELECTED_TABS_COLOR_START INACTIVE_UNSELECTED_TABS_COLOR_END 100% 100%;
    swt-outer-keyline-color: INACTIVE_TAB_OUTER_KEYLINE_COLOR;
    swt-inner-keyline-color: INACTIVE_TAB_INNER_KEYLINE_COLOR;
    swt-tab-outline: INACTIVE_TAB_OUTLINE_COLOR;
    padding: 0px 2px 2px;
    swt-shadow-visible: false;
    swt-mru-visible: false;
    color: INACTIVE_TAB_TEXT_COLOR;
}

.MPartStack.active {
    swt-selected-tab-fill: ACTIVE_TAB_BG_START ACTIVE_TAB_BG_END 100% 100%;
    swt-unselected-tabs-color: ACTIVE_UNSELECTED_TABS_COLOR_START ACTIVE_UNSELECTED_TABS_COLOR_END 100% 100%;
    swt-outer-keyline-color: ACTIVE_TAB_OUTER_KEYLINE_COLOR;
    swt-inner-keyline-color: ACTIVE_TAB_INNER_KEYLINE_COLOR;
    swt-tab-outline: ACTIVE_TAB_OUTLINE_COLOR;
    swt-shadow-visible: false;
}