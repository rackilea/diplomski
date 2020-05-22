/**
         * Reads all resources below the given path matching the filter criteria,
         * including the full tree below the path only in case the <code>readTree</code> 
         * parameter is <code>true</code>.<p>
         * 
         * @param context the current request context
         * @param parent the parent path to read the resources from
         * @param filter the filter
         * @param readTree <code>true</code> to read all subresources
         * 
         * @return a list of <code>{@link CmsResource}</code> objects matching the filter criteria
         *  
         * @throws CmsSecurityException if the user has insufficient permission for the given resource (read is required)
         * @throws CmsException if something goes wrong
         * 
         */
        public List readResources(CmsRequestContext context,
                CmsResource parent, CmsResourceFilter filter,
                boolean readTree) throws CmsException, CmsSecurityException {

            List result = null;
            CmsDbContext dbc = m_dbContextFactory.getDbContext(context);
            try {
                // check the access permissions
                checkPermissions(dbc, parent, CmsPermissionSet.ACCESS_READ,
                        true, CmsResourceFilter.ALL);
                result = m_driverManager.readResources(dbc, parent, filter,
                        readTree);
            } catch (Exception e) {
                dbc.report(null, Messages.get().container(
                        Messages.ERR_READ_RESOURCES_1,
                        context.removeSiteRoot(parent.getRootPath())), e);
            } finally {
                dbc.clear();
            }
            return result;
        }