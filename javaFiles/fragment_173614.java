/*
 * Client API to list all the indexes in a namespace, returns list of imd with
 * index information, Caller should free it up
 */
int
as_sindex_list_str(as_namespace *ns, cf_dyn_buf *db)
{
......