war {
   webInf { 
      with copySpec({
         from 'src/additionalWebInf1' 
         into 'myCustomFolder1'
      })
      with copySpec({
         from 'src/additionalWebInf2' 
         into 'myCustomFolder2'
      })
   }
}