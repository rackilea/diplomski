int id_hutang = model.getId_hutang().length;
int jlh_pengeluaran = model.getJlh_pengeluaran().length;
int id_keagenan = model.getId_keagenan().length;

int largest = Math.max(id_hutang,Math.max(jlh_pengeluaran,id_keagenan));

for(int i=0; i<largest; i++)
{
   String sql = "INSERT INTO surat_jalan (a, b, c) VALUES (?, ?, ?)";
   template.update(sql, 
                     (i<id_hutang)?model.getId_hutang()[i]:0, 

                     (i<jlh_pengeluaran)?model.getJlh_pengeluaran()[i]:0,

                     (i<id_keagenan)?model.getId_keagenan()[i]:0);
}