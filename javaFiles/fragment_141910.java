CREATE TABLE CertKeys (
    cert_id INT UNSIGNED AUTO_INCREMENT,
    cert_key VARCHAR(2732) NOT NULL,   -- base64 encoded
    -- or:  cert_key VARBINARY(2049) NOT NULL,   -- binary
    PRIMARY KEY (cert_id),
    UNIQUEY (cert_key) ) ENGINE=InnoDB;