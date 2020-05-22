create table if not exists patient_to_prescs(

patient_id INTEGER NOT NULL REFERENCES patients_table(id),

presc_id INTEGER NOT NULL REFERENCES prescs_table(id),

PRIMARY KEY(patient_id, presc_id));