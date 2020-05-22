/**
     * Make sure that Date columns are sorted in a DESCENDING order by default
     */
    @Override
    protected void onHeaderClick(Grid<ModelData> grid, int column)
    {
        if (cm.getColumn(column).getDateTimeFormat() != null)
        {
            SortInfo state = getSortState();

            if (state.getSortField() != null && state.getSortField().equals(cm.getColumn(column).getId()))
            {
                super.onHeaderClick(grid, column);
                return;
            }
            else
            {
                this.headerColumnIndex = column;
                if (!headerDisabled && cm.isSortable(column))
                {
                    doSort(column, SortDir.DESC);
                }
            }
        }
        else
        {
            super.onHeaderClick(grid, column);
            return;
        }
    }