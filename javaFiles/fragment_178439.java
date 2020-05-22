struct _PACKET_OID_DATA {
   ULONG Oid;                   ///< OID code. See the Microsoft DDK documentation or the file ntddndis.h
                                ///< for a complete list of valid codes.
   ULONG Length;                ///< Length of the data field
   UCHAR Data[1];               ///< variable-lenght field that contains the information passed to or received 
                                ///< from the adapter.
};