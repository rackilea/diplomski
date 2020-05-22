long[] mem_dim = { data.length };
 int mem_dataset_id = H5.H5Screate_simple( 1, mem_dim, mem_dim );

 H5.H5Dwrite(
          dataset_id,
          HDF5Constants.H5T_NATIVE_FLOAT,
          mem_dataset_id, 
          dataspace_id,
          HDF5Constants.H5P_DEFAULT,
          data );

 H5.H5Sclose( mem_dataset_id );