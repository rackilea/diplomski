struct Any
{
     private:
         void * data;
         datatype type;

     public:
         Any():
             data(NULL),
             type(dt_none)
         {}

         ~Any()
         {
             deleteData();
         }

         void deleteData()
         {
             // Because deleting a void * is UB, we have to check real datatype
             if (type != dt_char && type != dt_uchar && data != NULL)
             {
                 if (type == dt_double)
                     delete static_cast<double *>(data);
                 ....
             } 
             data = NULL;
         }

         datatype getType() const
         {
             return type;
         }

         void setChar(char v)
         {
             data = reinterpret_cast<void *>(v);
         } 


         char toChar() const
         {
             return static_cast<char>(reinterpret_cast<intptr_t>(data));
         } 

         .....

         void setDouble(double v)
         {
             deleteData();
             data = new double(v);
         }

         double toDouble() const
         {
             return *static_cast<double*>(data);
         }
};