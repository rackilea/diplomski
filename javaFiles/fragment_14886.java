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
             if (data != NULL)
             {
                 if (type == dt_char)
                     delete static_cast<char *>(data);
                 if (type == dt_uchar)
                     delete static_cast<unsigned char *>(data);
                 ....
             }   
         }

         datatype getType() const
         {
             return type;
         }

         void setChar(char v)
         {
             deleteData(); 
             data = new char(v);
             type = dt_char;
         } 


         char toChar() const
         {
             return *static_cast<char *>(data);
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